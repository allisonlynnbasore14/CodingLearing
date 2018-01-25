import turtle
import math


bob = turtle.Turtle()

def rect(x):
	for i in range(2):
		bob.fd(x)
		bob.lt(90)
		bob.fd(2*x)
		bob.lt(90)


def tri(x):
	for i in range(3):
		bob.fd(x)
		bob.lt(60+180)

def poly(x,l):
	total = 360
	eachang = total/x
	for i in range(x):
		bob.fd(l)
		bob.rt(eachang)

#this is the cheating way by using the turtle library
def circle(diameter):
	bob.circle(diameter/2)
#this is the hard way
def circle_hard(diameter):
	c = diameter*math.pi
	n = 50
	linelen = c/n
	poly(n, linelen)


def arc_make(degree,x, linelen):
	total = degree
	eachang = total/x
	for i in range(x):
		bob.fd(linelen)
		bob.rt(eachang)

def arc(degree,x):
	"""
	This takes a degree of the arc and how large of an arc as inputs

	"""
	c = 10*math.pi
	n = 10
	linelen = c/n
	arc_make(degree,x, linelen)

def flower_star():
	n = 10 #size step
	for i in range(5):
		bob.lt(100)
		for i in range(2): #makes a full petal
			bob.lt(300)
			for i in range(n): #makes half a petal
				bob.fd(20)
				bob.rt(10)

def flower_input(petals, size):
	n = 10 # size step
	for i in range(petals):
		bob.lt(40)
		for i in range(2): #makes a full petal
			bob.lt(300)
			for i in range(n): #makes half a petal
				bob.fd(size)
				bob.rt(10)


flower_input(10, 10)

turtle.mainloop()
