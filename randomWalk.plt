set terminal png fontscale 1.
set xlabel "{/:Italic x}"
set ylabel "{/:Italic p}"
set yrange [0:0.016]
set xrange[-150:150]
set output "randomWalk.png"
set title "Random Walk ({/:Italic t} = 1000)"
set style fill solid border lc rgb "black"
t = 1000
p = 0.5
s = sqrt(4*t*p*(1-p))
mu = t*(2*p-1)
f(x) = (1/sqrt(2*pi*s*s))*exp(-(x-mu)*(x-mu)/2/s/s)
filename = "Simulation-output-100000-0.5.txt"
plot filename with boxes notitle,f(x) lt 8 lw 5 notitle
