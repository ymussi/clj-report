(ns report.ip_valid.resolvers
  (:require [faker.address :as fake]
            [clj-http.client :as client]))

(def ^:private nomes
  ["United States", "Canada", "Brazil",
   "Afghanistan", "Albania", "Algeria",
   "American Samoa", "Andorra"])

(defn nome [] (rand-nth nomes))

(defn tipo-consulta
  []
  {:basic-pf "basic_pf"
   :ip_valid "ip_valid"
   })

(tipo-consulta)

(def ^:public locations
  {:country (fake/uk-country)
   :isvpn "true"
   :region (fake/us-state)
   :valid "false"
   :address (fake/street-address),
   :location-type "street",
   :country-code3 "DEU",
   :city (fake/city),
   :country-code "DE",
   :longitude 11.3400106,
   :state (fake/us-state)
   :blocklist {:isListed "false"
               :blockLists "false"}})

(defn geocode
    []
    (let [location-list locations]
      location-list))

(def ^:private booleansOpt
  ["true", "false"])

(defn booleanOpt [] (rand-nth booleansOpt))

(defn request-integrador
  []
  (client/post "http://localhost:5555/graphql"
               {:content-type :graphql
                :body "{
                       basic_pf(id: "13205550714"){
                         Age
                         Name
                         BirthDate
                         Gender
                         TaxIdStatus
                         MotherName
                         Financials{
                                    TaxReturnsBankCode
                                    TaxReturnsBankName
                                    TaxReturnsBankAgency
                                    TaxReturnsYear
                                    }

                         }"
                       }))


(defn base_64_image
  []
  "")

(def ^:private body-osas
  {:body (json/generate-string {:Base64  base_64_image})
                      :content-type :json
                      :as :json
                      :accept :json})

(defn request-test
  []
  (client/post "http://homologacao.ellosecm.com.br/QuodApi/api/cnh"))
