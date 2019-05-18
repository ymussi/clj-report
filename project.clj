(defproject clj-report "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-pdf "2.3.4"]
                 [faker "0.2.2"]
                 [clj-http "3.10.0"]]
  :main report.ip_valid.core
  :aot [report.ip_valid.core]
  :repl-options {:init-ns report.ip_valid.core})

