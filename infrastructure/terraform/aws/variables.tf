variable "aws_region" {
  description = "The AWS Region"
}

variable "ami_id" {
  description = "The AMI id"
}

variable "aws_key_name" {
  description = "The name of the AWS key pair"
}

variable "subnet_id" {
  description = "The subnet id"
}

variable "security_group_ids" {
  type = "list"
  description = "The list of security group ids"
}

variable "ssh_user" {
  description = "The SSH user"
}

variable "ssh_private_key" {
  description = "The path to the SSH private key"
}

variable "instance_profile_name" {
  description = "The name of the IAM instance profile for downloading artifacts from S3"
}

variable "gemfire_locator_private_ips" {
  type = "list"
  description = "A list of IPs for the gemfire locators"
}
