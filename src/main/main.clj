(ns main
  (:require [aero.core :as aero]
            [integrant.core :as ig]
            [reitit.ring :as ring]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [muuntaja.core]
            [reitit.ring.coercion :as ring.coercion]
            [reitit.coercion.malli :as malli.coercion]
            [ring.adapter.jetty :as jetty]
            [reitit.ring.middleware.parameters]
            [reitit.ring.middleware.exception]
            [reitit.ring.middleware.dev]
            [ring.util.http-response :as resp]
            [clojure.java.io :as io]))

(defmethod aero.core/reader 'ig/ref [_opts _tag value]
  (ig/ref value))

(defn system-config []
  (aero/read-config (io/resource "config.edn")))

(defn handler [_]
  (resp/ok {:test "kikka"}))

(defn app [_]
  (ring/ring-handler
   (ring/router
    ["/api"
     ["/foo" {:get {:handler #'handler}}]]
    {:data {:muuntaja muuntaja.core/instance
            :coercion reitit.coercion.malli/coercion
            :middleware [reitit.ring.middleware.parameters/parameters-middleware
                         muuntaja/format-middleware
                         ring.coercion/coerce-exceptions-middleware
                         ring.coercion/coerce-request-middleware
                         ring.coercion/coerce-response-middleware]}})))

(defmethod ig/init-key :web/routes [_ env]
  (app env))

(defmethod ig/init-key :adapter/jetty [_ {:keys [routes] :as opts}]
  (jetty/run-jetty routes (assoc opts :join? false)))

(defmethod ig/halt-key! :adapter/jetty [_ server]
  (.stop server))

(defn -main []
  (try
    (let [system (ig/init (system-config))]
      (.addShutdownHook
       (Runtime/getRuntime)
       (Thread. (fn [] (ig/halt! system))))
      system)
    (catch Throwable t)))
