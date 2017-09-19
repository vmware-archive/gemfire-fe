ami_id = "ami-d946b4a1"
security_group_ids = ["sg-4cf03b2a"]
aws_key_name = "gemfire-fe"
ssh_user = "centos"
subnet_ids = ["subnet-914ebfc9"]
instance_profile_name = "gemfire-fe"
availability_zones = ["us-west-2c"]

locator_count = 2
locator_instance_type = "t2.medium"
locator_private_ips = ["172.31.0.11","172.31.0.12"]

server_count = 2
server_instance_type = "t2.large"
server_private_ips = ["172.31.0.21","172.31.0.22"]
