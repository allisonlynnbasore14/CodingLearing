def store(items):
#""Returns the cost the iteam in this store"""
	total = 0 
	subtotal = 0
	for item in items:
		for i in item:
			cost = ord(i) - 96
			subtotal = subtotal + cost
		print('The cost of %s is %d.' % (item, subtotal))
		total = total + subtotal
	print('Your total is: %d.' % total)


store(['apples', 'banana' ,'cat', 'zebras','zzzzzzzzzzzz'])
