import os,sys,time,operator,io


path = os.getenv('localappdata') + '\\Google\\Chrome\\User Data\\Default\\Local

Storage\\'

history = []

for filename in os.listdir(path):

  if filename.endswith('localstorage') and filename.startswith('http'):

    history.append(path + filename)

history.sort(key=lambda x: os.path.getmtime(x))

f = open(os.getcwd()+'\\myHistory.txt','w')

for file in history :

  f.write(file[len(path):-15].replace('_', '://').ljust(100) +  time.ctime(os.path.getmtime(file)) +'\n')

f.close()

raw_input("Press Enter to finish ")
