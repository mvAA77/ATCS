import matplotlib as mpl
import matplotlib.pyplot as plt
import numpy as np

import random


bubbleSort = [150972400, 660364700, 1407012500, 3274927300, 4670441400, 6371407500, 7360648200, 9698824400, 12412254000, 15100550200]
quickSort = [2137500, 1618400, 1712900, 5714200, 5805600, 4238800, 5065700, 6703900, 6673300, 7465600]
x_axis = []

for i in range(10):
  x_axis.append(i * 1000)

plt.plot(x_axis, bubbleSort, label='Bubble Sort')
plt.plot(x_axis, quickSort, label='Quick Sort')

plt.xlabel("Array Size")
plt.ylabel("Time")

plt.title("Array Sort Execution Time")

plt.legend()
plt.show()