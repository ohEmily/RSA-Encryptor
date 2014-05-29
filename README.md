# RSA Encryption/Decryption Assignment (for COMS3134 Data Structures)

To run (after compiling):

java rsa/Makekeys bob
java rsa/Encode bob.public < message > code
java rsa/Encode bob.public < message | java rsa/Encode bob.private