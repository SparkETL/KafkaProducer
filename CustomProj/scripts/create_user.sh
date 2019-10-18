#!/usr/bin/env bash

MACHINES="$1 $2"
UNAME="hadoop"

readonly NAME
echo "Gonna create passwordless SSH with unique user-> $UNAME"
sudo useradd $UNAME -m -s /bin/bash
sudo passwd $UNAME
sudo usermod -aG sudo hadoop

ssh-keygen -b 4096
for machine in $MACHINES
do
    ssh-copy-id -i /home/$USER/.ssh/id_rsa.pub $machine
    echo "Passwordless SSH successfully created with user-> $UNAME at machine $machine"
done



sudo useradd hadoop -m -s /bin/bash




######
#go to master node
sudo su root
cd
ssh-keygen
#going to slavenodes
mkdir -p /home/hadoop/.ssh



ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDSF6kdyOwPAo8UOkh5t3hAfAOqe+5Mh/DtNEsozdHaDDyk4Wa55xqUdDF823lCZR+jCVucZyeqeSNPTssf4tMAR+R1wdOftYiygjISQnFsC1mZUDVBhpUUG4v9sTg5jqPYDFeLghuYyfXS0IRL
3VKxii40rQmjNCpmv1ZywuEH4RD+ZO0hXDbzdDUaTG2+5V/Syz/ohcw8aYTtoJ+BMYsdoKPtc3cbMzydkPxYU6c71A6fo4BJoJoNLw9tYfnOyx/TDCixgeMq44PX447F37y8pBQVhfs2lnUsIJ8qOeUEHWU+PTkssaEAFKQCOjrHZ2KWvHKq0UOF
E933YVl7dfzJ

echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDSF6kdyOwPAo8UOkh5t3hAfAOqe+5Mh/DtNEsozdHaDDyk4Wa55xqUdDF823lCZR+jCVucZyeqeSNPTssf4tMAR+R1wdOftYiygjISQnFsC1mZUDVBhpUUG4v9sTg5jqPYDFeLghuYyfXS0IRL
3VKxii40rQmjNCpmv1ZywuEH4RD+ZO0hXDbzdDUaTG2+5V/Syz/ohcw8aYTtoJ+BMYsdoKPtc3cbMzydkPxYU6c71A6fo4BJoJoNLw9tYfnOyx/TDCixgeMq44PX447F37y8pBQVhfs2lnUsIJ8qOeUEHWU+PTkssaEAFKQCOjrHZ2KWvHKq0UOF
E933YVl7dfzJ"> /home/hadoop/.ssh/authorized_keys
chmod 700 /home/hadoop/.ssh
chmod 640 /home/hadoop/.ssh/*

#go to master nodes
sudo ssh hadoop@10.160.0.3

