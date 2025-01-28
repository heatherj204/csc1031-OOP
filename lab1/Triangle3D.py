#!/usr/bin/env python3

import math

class Dot3D:
    def __init__(self, x, y, z, label=None):
        self.x = x
        self.y = y
        self.z = z
        self.label = label

    def distance_to(self, other):
        distance = math.sqrt((other.x - self.x)**2 + (other.y - self.y)**2 + (other.z - self.z)**2)
        return distance

    def add_vector(self, other):
        newX = self.x + other.x
        newY = self.y + other.y
        newZ = self.z + other.z
        newLabel = f'{self.label}+{other.label}'
        return(Dot3D(newX, newY, newZ, newLabel))

class Triangle3D:
    def __init__(self, dot1, dot2, dot3):
        self.dot1 = dot1
        self.dot2 = dot2
        self.dot3 = dot3

    def calculate_perimeter(self):
        # Calculate and return the perimeter of the triangle
        # P = A + B + C
        len1_2 = self.dot1.distance_to(self.dot2)
        len2_3 = self.dot2.distance_to(self.dot3)
        len3_1 = self.dot3.distance_to(self.dot1)
        p = len1_2 + len2_3 + len3_1
        return p

    def calculate_area(self):
        # Calculate and return the area of the triangle
        s = (self.calculate_perimeter()) / 2
        edge1 = self.dot1.distance_to(self.dot2)
        edge2 = self.dot2.distance_to(self.dot3)
        edge3 = self.dot3.distance_to(self.dot1)
        area = math.sqrt(s * ((edge1) * (s - edge2) * (s - edge3)))
        return area
