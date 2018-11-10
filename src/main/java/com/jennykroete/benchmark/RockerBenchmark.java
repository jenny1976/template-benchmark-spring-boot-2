package com.jennykroete.benchmark;

import com.fizzed.rocker.Rocker;
import com.jennykroete.benchmark.model.Stock;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import java.io.IOException;
import java.util.List;

/**
 * Benchmark for Rocker template engine by Fizzed.
 * 
 * https://github.com/fizzed/rocker
 * 
 * @author joelauer
 */
public class RockerBenchmark extends BaseBenchmark {

    private List<Stock> items;

    @Setup
    public void setup() throws IOException {
        // no config needed, replicate stocks from context
        this.items = Stock.dummyItems();
    }

    @Benchmark
    public String benchmark() {
        return Rocker.template("stocks.rocker.html", items)
                .render()
                .toString();
    }

}
