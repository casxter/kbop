#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
import mysql.connector



if __name__=='__main__':
	print("main")

	conn = mysql.connector.connect(host="121.42.158.251",user='kbop', password='b8wfFdG9HzFAZL9E', database='kbop')
	cursor = conn.cursor()

	for x in os.listdir('books/'):
		bookname = os.path.splitext(x)[0]
		ext = os.path.splitext(x)[1]
		print(bookname + "    " + ext[1:])
		
		size = os.path.getsize(os.getcwd() + '/books/' + x)
		sizestr = ''
		if size / 1024 > 1.0:
			if size / 1024 / 1024 > 1.0:
				sizestr = '%.2fMB' % (size / 1024 / 1024)
			else:
				sizestr = '%.2fKB' % (size / 1024)
		else:
			sizestr = '%.2fB' % size

		print(sizestr)

		sql = "update book set Ext= '" + ext[1:] + "',Size='" + sizestr +"' where BookName = '" + bookname + "'"

		print(sql)

		cursor.execute(sql)
			
		print('rowcount =', cursor.rowcount)
		#提交事务:
		conn.commit()

	cursor.close()
	conn.close()
