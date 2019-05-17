(ns data.resolvers
  (:require [faker.address :as fake]))

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

;(fake/city)

(defn geocode
    []
    (let [location-list locations]
      location-list))

(geocode)
;(:address (geocode))

(def ^:private booleansOpt
  ["true", "false"])

(defn booleanOpt [] (rand-nth booleansOpt))

(booleanOpt)


