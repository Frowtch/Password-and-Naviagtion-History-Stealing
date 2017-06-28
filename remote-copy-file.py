import paramiko, scp

from scp import SCPClient



ssh = paramiko.SSHClient()

ssh.load_system_host_keys()

ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())

ssh.connect('127.0.0.1', username='root', password='1r2o1t')

scp = SCPClient(ssh.get_transport())

scp.put("/media/sf_Python_Stuffs/HistoryRevisited.py",

"/root/Downloads/HistoryRevisited.py")

scp.close()

raw_input("done")
