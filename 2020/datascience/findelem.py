import time
bigList = [str(i) for i in range(1,10000001)]
start = time.time()
print "abc" in bigList
print "Elapsed %.3fms"%((time.time()-start)*1000)
start = time.time()
bigSet = set(bigList)
print "Elapsed %.3fms"%((time.time()-start)*1000)
start = time.time()
print "abc" in bigSet
print "Elapsed %.3fms"%((time.time()-start)*1000)
