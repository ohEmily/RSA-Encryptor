# RSA Encryption/Decryption Assignment (for COMS3134 Data Structures)

RSA encryption and decryption program. Generates public and private keys with which to run the decryption and encryption. (The files bob.public and bob.private contain the keys.)

### To run (after compiling):

java rsa/Makekeys bob
java rsa/Encode bob.public < message > code
java rsa/Encode bob.public < message | java rsa/Encode bob.private