import time
import matplotlib.pyplot as plt

from queue import Queue
from arraylistqueue import ArrayListQueue

def measure_times(queue_class, sizes):
    offer_times = []
    poll_times = []

    for n in sizes:
        q = queue_class()

        start = time.perf_counter_ns()
        for i in range(n):
            q.offer(i)
        end = time.perf_counter_ns()
        offer_times.append(end - start)

        start = time.perf_counter_ns()
        for i in range(n):
            q.poll()
        end = time.perf_counter_ns()
        poll_times.append(end - start)

    return offer_times, poll_times



sizes = [10_000 * i for i in range(1, 11)]  # 10k → 100k




ll_offer, ll_poll = measure_times(Queue, sizes)
arr_offer, arr_poll = measure_times(ArrayListQueue, sizes)



plt.figure(figsize=(12, 7))

plt.plot(sizes, ll_offer, label="LinkedList Queue Offer (O(1))", linestyle='-', linewidth=2)
plt.plot(sizes, ll_poll, label="LinkedList Queue Poll (O(1))", linestyle='--', linewidth=2)

plt.plot(sizes, arr_offer, label="ArrayList Queue Offer (O(1) amortized)", linestyle='-.', linewidth=2)
plt.plot(sizes, arr_poll, label="ArrayList Queue Poll (O(n))", linestyle=':', linewidth=2)

plt.title("Queue Performance Comparison: LinkedList Queue vs ArrayList Queue")
plt.xlabel("Dataset Size (n)")
plt.ylabel("Time (nanoseconds)")
plt.legend()

plt.annotate("O(1)", (sizes[-1], ll_offer[-1]),
             xytext=(sizes[-1] * 1.02, ll_offer[-1]))
plt.annotate("O(1)", (sizes[-1], ll_poll[-1]),
             xytext=(sizes[-1] * 1.02, ll_poll[-1]))

plt.annotate("O(1) amort.", (sizes[-1], arr_offer[-1]),
             xytext=(sizes[-1] * 1.02, arr_offer[-1]))

plt.annotate("O(n)", (sizes[-1], arr_poll[-1]),
             xytext=(sizes[-1] * 1.02, arr_poll[-1] * 1.05),
             arrowprops=dict(arrowstyle="->"))

plt.tight_layout()
plt.show()
