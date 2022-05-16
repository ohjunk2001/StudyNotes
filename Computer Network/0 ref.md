
https://www.javatpoint.com/computer-network-architecture

| Layer | Layer Name        | Function                                                     | PDU         | Addressing  | Protocol                | Device                      |
| ----- | ----------------- | ------------------------------------------------------------ | ----------- | ----------- | ----------------------- | --------------------------- |
| 5     | Application Layer | Running applications, Logical communication between APPs.    | Message     | URL...      | HTTP/FTP/SMTP/POP3....  | gateway                     |
| 4     | Transport Layer   | Logical communication between Processes.                     | Segment     | Port#       | TCP/UDP...              | gateway                     |
| 3     | Network Layer     | Logical communication between Hosts/Routing/Forwarding.      | IP Datagram | IP address  | IP/ICMP/RIP/OSPF/BGP    | Router                      |
| 2     | Data-link Layer   | Logical communication between neighboring (adjacent) nodes/LLC/MAC. | Frame       | MAC address | ARP/Ethernet/802.11 ... | Bridge/Switch/NIC           |
| 1     | Physical Layer    | bits on the write .../Transparently transmit bitstreams      | bits stream | /           | /                       | HUB/Repeater/physical media |

