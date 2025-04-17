(ns user
  (:require [main :refer :all]
            [integrant.repl :refer [go halt reset-all reset]]
            [integrant.repl.state :as state]
            [xtdb.client :as xtc]
            [xtdb.api :as xt]))

(def dev-db "http://localhost:3000")

(integrant.repl/set-prep!
 (fn [] ((requiring-resolve 'main/system-config))))
