#This is test code to learn pygame

import os, sys
import pygame
from pygame.locals import *
from helpers import *


if not pygame.font:
	print('Warning, fonts disabled')

if not pygame.mixer:
	print('Warning, sound disabled')


class PyManMain():
	"""The Main pygame class- handles the main initalization and creation of the game."""

	def __init__(self,width=640,height=480):
		"""Initalize"""
		pygame.init()
		"""Set window size"""
		self.width = width
		self.height = height
		"""Create Screen"""
		self.screen = pygame.display.set_mode((self.width, self.height))

		
	def MainLoop(self):
		"""Main Loop of the game that calls other functions"""
		"""Load all our Sprites"""
		self.LoadSprites();
		pygame.key.set_repeat(500,30)

		self.background = pygame.Surface(self.screen.get_size())
		self.background = self.background.convert()
		self.background.fill((0,0,0))


		while 1:
			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					sys.exit()
				elif event.type == KEYDOWN:
					if((event.key == K_RIGHT) or (event.key == K_LEFT)or (event.key == K_UP) or (event.key == K_DOWN)):
						self.snake.move(event.key)

			lstCols = pygame.sprite.spritecollide(self.snake, self.pellet_sprites, True)
			self.screen.blit(self.background,(0,0))

			if pygame.font:
				font = pygame.font.Font(None,36)
				text = font.render("Pellets %s" %self.snake.pellets, 1,(255,0,0))
				textpos = text.get_rect(centerx =self.background.get_width()/2)
				self.screen.blit(text, textpos)
		self.pellet_sprites.draw(self.screen)
		self.snake_sprites.draw(self.screen)
		pygame.display.flip()

	def LoadSprites(self):
		"""Load the sprites needed"""
		self.snake = Snake()
		self.snake_sprites = pygame.sprite.RenderPlain((self.snake))
		"""figure out how many pellets we can display"""
		nNumHorizontal = int(self.width/64)
		nNumVertical = int(self.width/64)
		self.pellet_sprites = pygame.sprite.Group()
		"""Create all of the pellets and add them to the pellet_sprites group"""
		for x in range(nNumHorizontal):
			for y in range(nNumVertical):
				self.pellet_sprites.add(Pellet(pygame.Rect(x*64, y*64, 64, 64)))


class Snake(pygame.sprite.Sprite):
	"""Main Character of game"""
	def __init__(self):
		pygame.sprite.Sprite.__init__(self)
		self.image, self.rect = load_image('snake.png',-1)
		"""sets the numbebr of pellets to 0 with each new snake"""
		self.pellets = 0
		self.x_dist = 5
		self.y_dist = 5
	def move(self, key):
		"""Move your self in one of the four directions according ot keybaord input"""
		xMove = 0;
		yMove = 0;
		if (key ==K_RIGHT):
			xMove = self.x_dist
		elif (key ==K_LEFT):
			xMove = -self.x_dist
		elif (key ==K_UP):
			yMove = -self.y_dist
		elif (key ==K_DOWN):
			yMove = self.y_dist
		self.rect.move_ip(xMove,yMove)
		"""Checkk for collision"""
#		lstCols = pygame.sprite.spritecollide(self.snake, self.pellet_sprites, True)
#		"""updates the amount of pellets eaten"""
#		self.snake.pellets = self.snake.pellets + len(lstCols)



class Pellet(pygame.sprite.Sprite):
	def __init__(self, rect=None):
		pygame.sprite.Sprite.__init__(self)
		self.image, self.rect = load_image('pellet.png',-1)
		if rect != None:
			self.rect = rect


if __name__=="__main__":
	MainWindow = PyManMain()
	MainWindow.MainLoop()
	