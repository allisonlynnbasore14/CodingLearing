


import pygame
pygame.init()
from helpers import *
import time
import random


white = (255,255,255)
black = (0,0,0)
red = (255,0,0)
green = (255,0,0)
blue = (255,0,0)
# a fourth parameter is degree of tranparency

display_height = 600#601
display_width = 800#786

block_move_size = 10
block_size = 10

FPS = 10 #frames per second



font = pygame.font.SysFont(None,50)



def snake(lead_x, lead_y, block_size):
	pygame.draw.rect(gameDisplay,white,[lead_x, lead_y,block_size,block_size])#where is draw, color, and cordinates 400 and 3000 = x,y and next two are width and height


def message_to_screen(msg, color):  #making a message to user
	screen_text = font.render(msg, True, color)
	gameDisplay.blit(screen_text, [display_width/2-50,display_height/2-50])


#surface that will be updated
gameDisplay = pygame.display.set_mode((display_width, display_height))  #tuple of scsreen size

pygame.display.set_caption('Example Game')

#pygame.display.update() #a parameter passes to this will update a specifici thing, but leaving it blank makes it update all
#pygame.display.flip() is the same thing as pygame.display.update

class Background(pygame.sprite.Sprite):
	def __init__(self, image_file, location):
		pygame.sprite.Sprite.__init__(self)
		self.image = pygame.image.load('space.png')
		self.rect = self.image.get_rect()
		self.rect.left, self.rect.top = location

BackGround = Background('space.png',[0,0])


def gameLoop():

	gameExit = False

	lead_x = (display_width/2)
	lead_y = (display_height/2)
	lead_x_change = 0 #makes it so you can hold down the key and it will keep moving
	lead_y_change = 0

	randAppleX = round(random.randrange(0, display_width-block_size)/10.0)*10.0
	randAppleY = round(random.randrange(0,display_height-block_size)/10.0)*10.0
	randAppleX = round(random.randrange(0, display_width-block_size)/10.0)*10.0
	randAppleY = round(random.randrange(0,display_height-block_size)/10.0)*10.0

	clock = pygame.time.Clock() #setting up frames per second

	#game loop
	while not gameExit:
		for event in pygame.event.get(): #getting the events
			if event.type == pygame.QUIT:  
				gameExit = True
			if event.type == pygame.KEYDOWN:
				if event.key == pygame.K_LEFT:
					lead_x_change = -block_move_size
					lead_y_change = 0 #keeps it from going diagonal
				elif event.key == pygame.K_RIGHT:
					lead_x_change = block_move_size
					lead_y_change = 0
				elif event.key == pygame.K_UP:
					lead_y_change = -block_move_size
					lead_x_change = 0
				elif event.key == pygame.K_DOWN:
					lead_y_change = block_move_size
					lead_x_change = 0

		if lead_x >= display_width or lead_x <= 0 or lead_y >= display_height or lead_y <= 0:
			gameExit = True

			"""This code makes it so it stops if you lift up
			if event.type == pygame.KEYUP:
				if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT:
					lead_x_change = 0
			"""
				

		lead_x += lead_x_change
		lead_y += lead_y_change

		#making the background
		#fill is something you apply to a surface object
		gameDisplay.fill(white)#one way to draw
		#between fill (above) and update is where you render other graphics
		gameDisplay.blit(BackGround.image, BackGround.rect)

		
		snake(lead_x, lead_y, block_size)
		#whichever object you render second will be on top
		pygame.draw.rect(gameDisplay, green, [randAppleX, randAppleY, block_size, block_size])
		#coordinates stop in top left
		#A better way to draw a rectangle is below
		"""gameDisplay.fill(red, rect = [200,200,50,50]) #this is less processing"""

		pygame.display.update()
 
		if lead_x == randAppleX and lead_y == randAppleY:
			randAppleX = round(random.randrange(0, display_width-block_size)/10.0)*10.0
			randAppleY = round(random.randrange(0,display_height-block_size)/10.0)*10.0



		clock.tick(FPS)#setting frames per second



gameLoop()
message_to_screen("You lose",white)
pygame.display.update()
time.sleep(2)
pygame.quit() #uninitalizes pygame
quit()#must have a quit 

