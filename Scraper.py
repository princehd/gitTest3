import os
import sys
from inspect import getsourcefile
from os.path import abspath
import cx_Oracle

dsn = cx_Oracle.makedsn("project-db-stu.ddns.net",1524, sid="xe")
connection=cx_Oracle.connect(user="campus_c_c_1111",password="smhrd3",dsn=dsn,encoding="UTF-8")
cur=connection.cursor()
