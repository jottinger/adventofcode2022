# Joseph Ottinger's Advent of Code 2022

* [Advent of Code, 2022](https://adventofcode.com/2022/about)
* Language: [Kotlin](https://kotlinlang.org/)
* [Private Leaderboard](https://adventofcode.com/2022/leaderboard/private/view/221181)

## Notes

> If you have not done the Advent of Code exercises, *BEWARE OF 
> READING MY NOTES!* There are going to be some minor spoilers, I 
> guarantee it. You're better off doing the exercises and _then_ 
> reading the notes.

* [Day 1](#day01)
* [Day 2](#day02)
* [Day 3](#day03)

### <a name="day01">Day 01</a>

Fun one, to get started. Still working out code organization.

### <a name="day02">Day 02</a>

Done! This one was funny, because it actually played on one of the 
things that upsets me most about coding: changing requirements and 
coding based on assumptions. In real life, I'd have not bothered 
with part 1, because it relied on me inferring requirements that, 
well, ended up being drastically wrong, and that _definitely_ 
affected the shape of the solution, especially considering that I 
needed both results.

In retrospect, I got it "right" but I'm really unhappy with the 
process of accomplishing that. I should have added a transformation 
step to migrate the two input specifications into a common form, and 
evaluated *that* - it would have simplified *everything*. The 
incomplete specs and the time factor (as I'm in a race with other 
coders) worked against that.

### <a name="day03">Day 03</a>

I anticipated the data structures better this time, sort of - I'm 
still being awfully stingy with types, mostly because these are all 
one-shot solutions.

I ended up implementing a control-break - yeah, COBOL for the win, 
in Kotlin, right? - but that's the *fastest* solution I could think 
of to write. I want to figure out how to collect groups of elements 
by index in Kotlin; that would have made the solution *much* cleaner.
