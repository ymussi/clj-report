(ns report.ip_valid.core
  (:use clj-pdf.core)
  (:require [report.ip_valid.resolvers :as faker]))

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
     {:size 15 :align :center}} " - Resultados da consulta - " (:ip_valid (faker/tipo-consulta))]

   [:paragraph {:size 15 :cellSpacing 20} "\n1 - Campo 1"]

   [:table {:header [{:background-color [128 128 128]} "Campo" "Resultado"] :cellSpacing 20}
    ["Country" (:country (faker/geocode))]
    ["IsVPN" (:isvpn (faker/geocode))]
    ["Region" (:region (faker/geocode))]
    ["City" (:city (faker/geocode))]
    ["BlockList" (:blocklist (faker/geocode))]]

   [:paragraph {:size 15 :cellSpacing 20} "\n1 - Campo 2"]

   [:table {:header [{:background-color [128 128 128]} "Campo" "Resultado"] :cellSpacing 20}
    ["Country" (:country (faker/geocode))]
    ["Address" (:address (faker/geocode))]]

   ]

  "report_consultas.pdf")

(:address (faker/geocode))
(faker/geocode)
