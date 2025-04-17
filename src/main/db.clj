(ns db
  (:require [xtdb.api :as xt]
            [xtdb.client :as xtc]
            [integrant.core :as ig]))

(def dev-db "http://localhost:3000")

#_(defmethod ig/init-key :database/xtdb [_ opts]
  opts)

(defn node [connection-string]
  (xtc/start-client connection-string))

(defn tx [txs]
  (with-open [node (node dev-db)]
    (xt/submit-tx node txs)))

(defn q [q' & [opts]]
  (with-open [node (node dev-db)]
    (xt/q node q' opts)))

(defn delete-all-in [table]
  (with-open [node (xtc/start-client dev-db)]
    (xt/submit-tx node [(into [:delete-docs table]
                              (map :xt/id)
                              (xt/q node (list 'from table ['xt/id])))])))

(comment
  (with-open [node (node dev-db)]
    (xt/status node))


  (with-open [node (node dev-db)]
    (xt/q node "SELECT * from information_schema.tables where table_schema = 'public';"))

  (with-open [node (node dev-db)])

  (q '(from :information_schema.tables [*]))
  )
