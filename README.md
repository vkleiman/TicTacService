After unpacking you can issue mvn test to run the tests

The service has one method move:
String pos - initial position
int sz - size of the board
char comp - computer character
char user - user character

Returns new position as String or throws an exception for bad arguments or bad position

Position is a string, which contains the current position (it must be exactly sz^2 chars in length)
computer moves are indicated by comp param, user moves by user param, empty spaces by space character,
only these 3 chars are allowed to be in the string.
comp char and user char must be different and neither can be a space.

Number of computer moves must equal or one less than user move, otherwise an exception is thrown. 
If the board contains no spaces an exception is thrown.
If one side has already won an exception is thrown.

Otherwise computer move is made by placing comp char in first available position.
