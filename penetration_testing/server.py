import socket
import time
s = socket.socket()
print ("Socket successfully created")

port = 13549

s.bind(('', port))
print ("socket binded to %s" %(port))

s.listen(5)
print ("socket is now listening")

while True:
    c, addr = s.accept()
    print ("Got connection from", addr)