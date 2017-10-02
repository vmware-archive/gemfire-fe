#!/bin/bash

set -exv

## update
apt-get -y update
#apt-get -y upgrade

## install python and pip
apt-get -y install python
apt-get -y install python-pip

## install python modules for ansible
pip install boto boto3 psycopg2
