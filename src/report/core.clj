(ns report.core
  (:use clj-pdf.core))

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
    ["Resultados" "teste2"]]
   ]

  "report_consultas.pdf")