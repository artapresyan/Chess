#<ins><p align="center">Chess
Chess is believed to have been invented 1500 years ago in India. It is an abstract strategy board game (game where
the theme is not important to the experience of playing) played between two players and involves no hidden information.
It is played on a square chessboard with 64 squares arranged in an eight-by-eight grid. At the start, each player 
(one controlling the white pieces, the other controlling the black pieces) controls sixteen pieces: one king, one 
queen, two rooks, two knights, two bishops, and eight pawns. The object of the game is to checkmate the opponent's 
king, whereby the king is under immediate attack (in "check") and there is no way for it to escape. There are also
several ways a game can end in a draw.\
###*If you want to learn how to play Chess follow this link and check out the rules.(https://en.wikipedia.org/wiki/Rules_of_chess)

#<ins><p align="center">Why I built this project
Hi, I'm Arthur, a self-taught novice programmer, and this is the first project that I decided to push in GitHub.
After some Java courses, that I found on the internet, for improving my OOP skills I have implemented chess in Java.
When I started doing this project I made a lot of mistakes and thanks to them, I learned a lot. I was always afraid 
of mistakes, but after this project, I realized that the mistakes that I made would never be repeated. With every step 
of my career, I don't forget the nuances that I have learned and am ready to accept new mistakes as a new experience.

#<ins><p align="center">How to use
When you run the program console will print the start board and player with white figures will start the game. At first 
input, you enter the coordinates of figure that you want to take(ex. A(a)1,B(b)2 etc.), after taking now you must enter 
coordinates of the field that you want to put your figure. After each move console prints the new board. When your 
reached the end of the board with a pawn, you can turn it into another figure by writing the name of the piece
(Knight(knight), Queen(queen), etc.).

#<ins><p align="center">Main features
1. You can't take wrong figure or empty field
2. Every nuance was calculated, so you can't make a wrong move
    * wrong trajectory
    * other movement nuances
        * figure eating
        * go over figure except knight
        * castling
        * etc.
    * let king checked(if you can eliminate the king's check)
    * open check for king
    * put king in check
    * etc.
3. If the pawn has reached the end of the board, he can choose a figure that is allowed according to the chess rules
4. Automatically make the game ended due to mate
5. Automatically make the game ended due to stalemate


