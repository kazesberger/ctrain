# ctrain

Run the 4clojure problems without having to load a graphical browser or desktop session. Even do it over ssh!

## Usage

1. Install Java and [Leiningen](https://leiningen.org/) if needed.
2. Clone this repo and type `lein run` while in the ctrain directory.

When you get a problem right it saves your progress and stores your answer on disk.

## TODO

1. There's currently no error handling. It actually evaluates the expressions you enter, so it will freak out and crash if you put in something that doesn't make sense like an undefined symbol. You can avoid having to restart the JVM by calling `(-main)` from the REPL instead.

2. It has no concept of restricted functions in your answer. It's just a dirty free-for-all.
