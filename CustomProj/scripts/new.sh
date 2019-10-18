#!/usr/bin/env bash

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






#To add new unique user in Cluster follow the steps  =no -q siguavus@${
#usname = ""
1. useradd usname on all nodes
2. passwd usname on all nodes
3. add user to sudoers

4. on master node: su root ; ssh-keygen and now open the pub key and copy whole key except "root@....."
5. Go to each node including master node: through root user, mkdir -p /home/siguavus/.ssh ;
    echo "<public key of root of master node>" > /home/usname/.ssh/authorized_keys ; chmod 700 /home/usname/.ssh ; chmod 640 /home/usname/.ssh/

6. Now all the servers will be keyless from master node only through usname user, to login : sudo ssh usname@<node>
