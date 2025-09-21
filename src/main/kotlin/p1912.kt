package p1912

import java.util.LinkedList
import java.util.PriorityQueue

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {

    // <shop, movie>, price
    val priceInfo = HashMap<Pair<Int, Int>, Int>()
    val waitMovieMap = HashMap<Int, PriorityQueue<Movie>>()
    val rentedMovies = PriorityQueue<Movie>()

    val containsWaitMovie = HashSet<Pair<Int, Int>>()
    val containsRentedMovie = HashSet<Pair<Int, Int>>()

    // <shop, movie>
    val rented = HashSet<Pair<Int, Int>>()

    init {
        entries.forEach { (shop, movie, price) ->
            priceInfo[Pair(shop, movie)] = price
            val pq = waitMovieMap.computeIfAbsent(movie) {
                PriorityQueue()
            }
            pq.add(Movie(shop, movie, price))
            containsWaitMovie.add(Pair(shop, movie))
        }
    }

    fun search(movie: Int): List<Int> {
        val pq = waitMovieMap[movie] ?: return emptyList()
        val tmpQueue = LinkedList<Movie>()
        while (!pq.isEmpty() && tmpQueue.size < 5) {
            val obj = pq.poll()
            if (rented.contains(Pair(obj.shop, obj.movie))) {
                containsWaitMovie.remove(Pair(obj.shop, obj.movie))
                continue
            }
            tmpQueue.add(obj)
        }
        val ret = mutableListOf<Int>()
        while (!tmpQueue.isEmpty()) {
            val obj = tmpQueue.poll()
            ret.add(obj.shop)
            pq.add(obj)
        }
        return ret
    }

    fun rent(shop: Int, movie: Int) {
        rented.add(Pair(shop, movie))
        if (containsRentedMovie.contains(Pair(shop, movie))) {
            return
        }
        val price = priceInfo[Pair(shop, movie)]!!
        rentedMovies.add(Movie(shop, movie, price))
        containsRentedMovie.add(Pair(shop, movie))
    }

    fun drop(shop: Int, movie: Int) {
        rented.remove(Pair(shop, movie))
        if (containsWaitMovie.contains(Pair(shop, movie))) {
            return
        }
        val price = priceInfo[Pair(shop, movie)]!!
        val pq = waitMovieMap.computeIfAbsent(movie) {
            PriorityQueue()
        }
        pq.add(Movie(shop, movie, price))
        containsWaitMovie.add(Pair(shop, movie))
    }

    fun report(): List<List<Int>> {
        val tmpQueue = LinkedList<Movie>()
        while (!rentedMovies.isEmpty() && tmpQueue.size < 5) {
            val obj = rentedMovies.poll()
            if (!rented.contains(Pair(obj.shop, obj.movie))) {
                containsRentedMovie.remove(Pair(obj.shop, obj.movie))
                continue
            }
            tmpQueue.add(obj)
        }
        val ret = mutableListOf<List<Int>>()
        while (!tmpQueue.isEmpty()) {
            val obj = tmpQueue.poll()
            ret.add(listOf(obj.shop, obj.movie))
            rentedMovies.add(obj)
        }
        return ret
    }

    data class Movie(val shop: Int, val movie: Int, val price: Int): Comparable<Movie> {
        override fun compareTo(other: Movie): Int {
            if (price == other.price) {
                if (shop == other.shop) {
                    return movie - other.movie
                }
                return shop - other.shop
            }
            return price - other.price
        }
    }
}
