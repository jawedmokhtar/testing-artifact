import socket
import sys

from struct import *

# Covert a string
def eth_addr (a) :
    b = "%.2x: %.2x: %.2x: %.2x: %.2x: %.2x: " % (ord(a[0]), ord(a[1]), ord(a[2]), ord(a[3]), ord(a[4]), ord(a[5]))
    return  b

# create a AF_packet
try:
    s = socket.socket(socket, socket.SOCK_RAW, socket.ntohs(0x0003))
except socket.error, msg:
    print 'Socket could be created. Error Code :' + str(msg[0]) + 'Message ' + msg[1]
    sys.exit()

while True:
    packet = s.recvfrom(65565)

    packet = packet[0]

    eth_length = 14
    eth_header = packet[:eth_length]
    eth = unpack('!6s6sH' , eth_header)
    eth_protocol = socket.ntohs(eth[2])
    print 'Destination MAC :' + eth_addr(packet [0:6]) + 'Source Mac : ' + eth_addr(packet[6:12]) + 'Protocol : ' + str(eth_protocol)