; http://download.oracle.com/docs/cd/E17409_01/javase/tutorial/uiswing/layout/border.html
(ns border-layout
  (:import (java.awt BorderLayout Dimension ComponentOrientation))
  (:import (javax.swing JButton JFrame)))

(defn- add-components-to-pane
  [pane]
  (let [page-start (JButton. "page start")
        center     (JButton. "center")
        line-start (JButton. "line start")
        page-end   (JButton. "page end")
        line-end   (JButton. "line end") ]
    (do
      (.setComponentOrientation pane ComponentOrientation/RIGHT_TO_LEFT)
        (doto pane
          (.add page-start BorderLayout/PAGE_START)
          (.add center BorderLayout/CENTER)
          (.add line-start BorderLayout/LINE_START)
          (.add page-end BorderLayout/PAGE_END)
          (.add line-end BorderLayout/LINE_END))
        (.setPreferredSize center (Dimension. 200 100)))))

(defn border-example []
  (let [frame (JFrame. "border example") pane (.getContentPane frame) ]
    (add-components-to-pane pane)
    (.pack frame)
    (.setVisible frame true)))

(border-example)
