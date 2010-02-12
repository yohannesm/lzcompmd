NAMES: David T. Kraft  Yohannes M. Himawan
UT EIDS: dtk265 ymh79
SECTIONS: 54195 54185

CODING STATUS: Working perfectly, but lacking assertions

In some cases, the .cpz file is larger than the original file. This happens when
stored dictionary strings do not repeat themselves often, and the dictionary creates
a bunch of very shallow nodes instead of a few deeper nodes.

For example, our smaller.txt file consists of a bunch of repeating characters. So the
Trie in our program gets deep very quickly. Our larger.txt file consists of no
repeating characters, so it becomes much bigger because in addition to encoding each
character, we also encode the number 0 with each character. So the file is bigger.
