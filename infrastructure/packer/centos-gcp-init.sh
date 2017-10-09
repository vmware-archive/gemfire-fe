#!/bin/bash

set -exv

## install epel
yum -y install epel-release

## update
yum update -y

## install basic and useful tools
yum -y install net-tools bind-utils sysstat hdparm iotop traceroute strace iperf3 ntp tcpdump wget unzip vim python python-pip python-lxml

## install boto, boto3, psycopg2 for ansible 
pip install boto boto3 psycopg2

## disable selinux
cat <<EOF >/etc/selinux/config
SELINUX=disabled
SELINUXTYPE=targeted
EOF

## sysctl perf settings
cat <<EOF >/etc/sysctl.d/90-perf.conf
fs.file-max = 2097152
vm.swappiness = 0
net.core.somaxconn = 1024
net.core.netdev_max_backlog = 4096
net.core.rmem_max = 16777216
net.core.wmem_max = 16777216
net.ipv4.tcp_wmem = 4096 12582912 16777216
net.ipv4.tcp_rmem = 4096 12582912 16777216
net.ipv4.tcp_syncookies = 0
net.ipv4.tcp_max_syn_backlog = 4096
EOF

## ulimits
cat <<EOF >/etc/security/limits.d/30-nofile.conf
* hard nofile 65536
* soft nofile 65536
EOF

## enable ntp daemon
systemctl enable ntpd

sync
