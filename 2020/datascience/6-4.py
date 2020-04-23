'''
그래프 그리기
'''
import numpy as np
import matplotlib.pyplot as plt

'''
x = np.linspace(-20, 20, 100)
y = x**2

plt.plot(x, y)
plt.axis([-25, 25, -0.1, 400.1])
plt.xticks(range(-20, 21, 5))
plt.show()
'''

sig_amp = 10
offset = 2
period = 100
noise_amp = 1
n_samples = 5 * period
range = 8

times = np.arange(n_samples)
signal = sig_amp * np.sin(2 * np.pi * times / period) + offset
noise = noise_amp * np.random.normal(size=n_samples)
signal += noise

signal[signal > range] = range
signal[signal < -range] = -range

plt.plot(times, signal)
plt.title("Sine signal with noise")
plt.xlabel("time")
plt.ylabel("signal")
plt.show()
