(ns quantumcalc.statechart.main
  (:require [nodename.stately.statechart :as statechart]
            [quantumcalc.statechart.alert :refer [alert]]
            [quantumcalc.statechart.calc :refer [app calc
                                                 operand1 operand2
                                                 keypad display]]
            [re-frame.core :as re-frame]))


(defonce state-machines {;;:alert alert ;; Alert out until bubbling from concurrent states is fixed
                         :app app
                         :calc calc
                         :operand1 operand1
                         :operand2 operand2
                         :keypad keypad
                         :display display})

(defonce middleware
  [re-frame/debug
   re-frame/trim-v])

(defn register-statechart
  []
  (statechart/register-statechart middleware state-machines :app))
