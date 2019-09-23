(ns clj-ttt.core-spec
  (:require [speclj.core :refer :all]
            [clj-ttt.core :refer :all]))

(describe "A new game of tic-tac-toe begins with:"
          (it "an empty board labeled 1-9"
              (should= "1 2 3\n4 5 6\n7 8 9\n" (with-out-str(print-board starting-board))))

          ;(it "with a current player X"
          ;    (should= "X" player-sequence))
          )

(describe "As a game is played:"
          ;(it "the current player switches at the end of a valid turn"
          ;    ())
          ;(it "a board cannot be marked in a filled cell"
          ;    ())
          (it "a board with empty cells can be marked"
              (should= [:X :X :X :O :O :O 7 8 9]
                       (with-in-str "1" (take-turn :X [1 :X :X :O :O :O 7 8 9]) )))
          )

(describe "a game of tic-tac-toe ends when:"
          (it "a board is full"
              (should (full-board? [:X :O :X :X :O :O :O :X :X])))
          (it "a game is a draw if board is full"
              (should= "current board:\nX O X\nX O O\nO X X\nGame is a draw.\n" (with-out-str(play-game [:X :O
              :X :X :O :O :O :X :X] player-sequence))))

          ;(it "has a winning combination"
          ;    (should= ((:X :X :X) (:O :O 6) (7 8 9) (:X :O 7) (:X :O 8) (:X 6 9) (:X :O 9) (:X :O 7))
          ;             (winning-boards [:X :X :X :O :O 6 7 8 9])))

          (it "has a message that declares the winner X"
              (should= "current board:\nX X X\nO O 6\n7 8 9\nPlayer X wins!\n" (with-out-str(play-game [:X :X :X :O :O 6 7 8 9] player-sequence))))

          (it "has a message that declares the winner O"
              (should= "current board:\n1 X X\nO O O\n7 8 9\nPlayer O wins!\n" (with-out-str(play-game [1 :X :X :O
                                                                                                        :O :O 7 8 9]
                                                                                                       player-sequence))))
          )
