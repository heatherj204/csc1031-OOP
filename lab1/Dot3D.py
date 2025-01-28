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

#TEST CODE

# dot1 = Dot3D(3, 4, 5, "x1")
# dot2 = Dot3D(6, 8, 10, "x2")

# distance = dot1.distance_to(dot2)
# print(distance)  # 7.0710678118654755

# resultant = dot1.add_vector(dot2)
# print(resultant)  # returns Dot3D(9, 12, 15, label="x1+x2")