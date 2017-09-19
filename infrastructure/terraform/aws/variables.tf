variable "aws_region" {
  description = "The AWS Region"
}

variable "ami_id" {
  description = "The AMI id"
}

variable "aws_key_name" {
  description = "The name of the AWS key pair"
}

variable "subnet_ids" {
  type = "list"
  description = "The subnet id"
}

variable "availability_zones" {
  type = "list"
  description = "The availability zone"
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

variable "locator_count" {
  description = "The locator count"
}

variable "locator_instance_type" {
  description = "The locator instance type"
}

variable "locator_private_ips" {
  type = "list"
  description = "A list of IPs for the gemfire locators"
}

variable "server_count" {
  description = "The server count"
}

variable "server_instance_type" {
  description = "The locator instance type"
}

variable "server_private_ips" {
  type = "list"
  description = "A list of IPs for the gemfire locators"
}
