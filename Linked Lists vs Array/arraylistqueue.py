class ArrayListQueue:
    def __init__(self):
        self.data = []

    def offer(self, value):
        self.data.append(value)

    def poll(self):
        if not self.data:
            return None
        return self.data.pop(0)
