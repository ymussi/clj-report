(ns report.core
  (:use clj-pdf.core)
  (:import [java.awt Color]))

;(pdf
;  [{}
;   [:list {:roman true}
;    [:chunk {:style :bold} "Item em negrito"]
;    "another item"
;    "yet another item"]
;   [:phrase "some text"]
;   [:phrase "some more text"]
;   [:paragraph "yet more text"]]
;  "doc.pdf")
;

;(def stylesheet
;  {:foo {:color [255 0 0]
;         :family :helvetica}
;   :bar {:color [0 0 255]
;         :family :helvetica}
;   :baz {:align :right}})
;
;(pdf
;  [{:stylesheet stylesheet}
;   [:paragraph.foo "item: 0"]
;   [:paragraph.bar "item: 1"]
;   [:paragraph.bar.baz "item: 2"]]
;  "doc.pdf")

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
   {:title         "Test doc"
    :header        "page header"
    :subject       "Some subject"
    :creator       "Jane Doe"
    :doc-header    ["inspired by" "William Shakespeare"]
    :right-margin  50
    :author        "John Doe"
    :bottom-margin 10
    :left-margin   10
    :top-margin    20
    :size          "a4"
    :footer        "page"}

   ;[:image
   ; {:xscale     0.5
   ;  :yscale     0.8
   ;  :align      :center
   ;  :annotation ["FOO" "BAR"]
   ;  :pad-left   100
   ;  :pad-right  50}
   ; (javax.imageio.ImageIO/read (-> "images/logo.jpg" clojure.java.io/resource clojure.java.io/file) )]
   [:image "images/header_tomatico.PNG"]

   [:heading
    {:style
     {:size 15 :align :center}} "Captalys Platform - Resultados da consulta (Idwall)"]

   ;[:chunk {:x 10 :y 10} [:image {:width 16 :height 16} "images/logo.jpg"]]


   [:table {:header [{:background-color [100 100 100]} "1.1 - Validações"] :cellSpacing 20}
    ["Sanções Nações Unidas"]

    ;["foo1" [{:background-color [100 100 100]} "bar1"]]
    ]

   


   ]

  "report_consultas.pdf")