(ns report.core
  (:use clj-pdf.core)
  (:import [java.awt Color]))

(defn radians [degrees] (Math/toRadians degrees))

(defmacro rot [g2d angle & body]
  `(do (. ~g2d rotate (radians ~angle))
       (do ~@body)
       (. ~g2d rotate (radians (- 0 ~angle)))))

(defmacro trans [g2d dx dy & body]
  `(do (. ~g2d translate ~dx ~dy)
       (do ~@body)
       (. ~g2d translate (- 0 ~dx) (- 0 ~dy))))

(defn draw-tree [g2d length depth]
  (when (pos? depth)
    (.drawLine g2d 0 0 length 0)
    (trans g2d (int length) 0
           (rot g2d -30 (draw-tree g2d (* length 0.75) (- depth 1)))
           (rot g2d 30 (draw-tree g2d (* length 0.75) (- depth 1))))))

(pdf
  [
   {:title         "Report"
    :header        ""
    :subject       ""
    :creator       ""
    :doc-header    [""]
    :right-margin  50
    :author        ""
    :bottom-margin 10
    :left-margin   10
    :top-margin    20
    :size          "a4"
    :footer        "page"}

   [:image {:align :center :width 100 :height 75} "images/logo.PNG"]

   [:heading
    {:style
     {:size 15 :align :center}} "Captalys Platform - Resultados da consulta"]


   [:table {:header [{:background-color [100 100 100]} "1.1 - Validações"] :cellSpacing 20}
    ["Resultados" "teste2"]
    ]
   ]

  "report_consultas.pdf")