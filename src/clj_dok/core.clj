(ns clj-dok.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.params :as params]
            [ring.util.response :as response]))

(defn handler [request]
  (let [params (:params request)]
    (response/response (str "Hello, " (or (:name params) "World!") "\n"))))

(def app
  (-> handler
      (params/wrap-params)))

(def server (atom nil))

(defn -main []
  (reset! server (jetty/run-jetty app {:port 3000 :join? false}))
  ;; 
  )

(comment
  (-main)
  (.stop @server)

  ;; 
  )
