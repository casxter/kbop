#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
import mysql.connector
import uuid

if __name__=='__main__':
	print("main")

	conn = mysql.connector.connect(host="121.42.158.251",user='kbop', password='b8wfFdG9HzFAZL9E', database='kbop')
	cursor = conn.cursor()

	i = 0

	for x in os.listdir('books/'):
		bookname = os.path.splitext(x)[0]
		ext = os.path.splitext(x)[1]

		#print(bookname + "    " + ext[1:])

		newname = uuid.uuid4().hex

		print(newname)

		os.rename(os.getcwd() + "/books/" + x,os.getcwd() + "/books/" + newname + ext)

		sql = "update book set URL= '" + newname + "' where BookName = '" + bookname + "'"

		#print(sql)

		cursor.execute(sql)

		i = i + 1

		print(str(i) +' rowcount =', cursor.rowcount)
		#提交事务:
		conn.commit()

	cursor.close()
	conn.close()
