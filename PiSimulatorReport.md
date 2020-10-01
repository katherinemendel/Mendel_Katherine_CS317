# Pi Simluation Report

In order to reliably compute pi, this simulation required approximately 100,000 darts. The results of four experiments, recorded below, illustrate that increasing the number of darts resulted in more precise approximations of pi.

**Experiment 1 - Using 10 games and increasing Darts**
Games | Darts | Estimate | STD
------------ | ------------- | ------------ | -------------
10 | 100 | 3.16 | 0.089442
10 | 1000 | 3.1236 | 0.047546
10 | 10000 | 3.13652 | 0.020626
10* | 100000 | 3.142596 | 0.003278



**Experiment 2 - Using 20 games and increasing Darts**
Games | Darts | Estimate | STD
------------ | ------------- | ------------ | -------------
20 | 100 | 3.186 | 0.158126
20 | 1000 | 3.1192 | 0.071806
20 | 10000 | 3.1342 | 0.015502
20* | 100000 | 3.1415 | 0.0063



**Experiment 3 - Using 50 games and increasing darts**
Games | Darts | Estimate | STD
------------ | ------------- | ------------ | -------------
50 | 100 | 3.132 | 0.169375
50 | 1000 | 3.1501 | 0.048054
50 | 10000 | 3.1376 | 0.016279
50* | 100000 | 3.1417 | 0.004139

In the results above, starred rows indicate where the game correctly estimated pi to three digits 50 times in a row. As the number of darts increased in each experiment, the standard deviation approached zero. This indicates that as more darts are thrown the estimate becomes more precise - meaning that a most points lie near the mean value.

**Experiment 4 - Using 1,500 darts and increasing games**
Games | Darts | Estimate | STD
------------ | ------------- | ------------ | -------------
10 | 1500 | 3.11493 | 0.037131
20 | 1500 | 3.15093 | 0.034289
30 | 1500 | 3.11511 | 0.036791
50 | 1500 | 3.13962 | 0.038558
100 | 1500 | 3.13874 | 0.041665

Increasing the number of games while controlling the number of darts thrown did not have a significant impact on the precision of the estimate. This is most clearly seen from the lack of any downward trend in the standard deviation.
