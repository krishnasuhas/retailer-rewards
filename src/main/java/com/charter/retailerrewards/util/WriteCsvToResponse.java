package com.charter.retailerrewards.util;

import com.charter.retailerrewards.model.Customer;
import com.charter.retailerrewards.model.Summary;
import com.charter.retailerrewards.model.Transaction;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;

import static java.lang.String.join;


public class WriteCsvToResponse {
    private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);

    public static void writeCustomers(PrintWriter writer, List<Customer> customers) {
        try {
            StatefulBeanToCsv<Customer> builder = getCustomerStatefulBean(writer);
            builder.write(customers);
        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    public static void writeCustomer(PrintWriter writer, Customer customer) {
        try {
            StatefulBeanToCsv<Customer> builder = getCustomerStatefulBean(writer);
            builder.write(customer);
        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    private static StatefulBeanToCsv<Customer> getCustomerStatefulBean(PrintWriter writer) {
        ColumnPositionMappingStrategy<Customer> mapStrategy = new ColumnPositionMappingStrategy<>();

        mapStrategy.setType(Customer.class);

        String[] columns = new String[]{"id", "name"};
        mapStrategy.setColumnMapping(columns);

        return new StatefulBeanToCsvBuilder<Customer>(writer.append(join(",", columns)).append("\n"))
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withMappingStrategy(mapStrategy)
                .withSeparator(',')
                .build();
    }

    public static void writeTransactions(PrintWriter writer, List<Transaction> transactions) {
        try {
            StatefulBeanToCsv<Transaction> builder = getTransactionStatefulBean(writer);
            builder.write(transactions);
        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    public static void writeTransaction(PrintWriter writer, Transaction transaction) {
        try {
            StatefulBeanToCsv<Transaction> builder = getTransactionStatefulBean(writer);
            builder.write(transaction);
        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    private static StatefulBeanToCsv<Transaction> getTransactionStatefulBean(PrintWriter writer) {
        ColumnPositionMappingStrategy<Transaction> mapStrategy = new ColumnPositionMappingStrategy<>();

        mapStrategy.setType(Transaction.class);

        String[] columns = new String[]{"id", "price", "customer"};
        mapStrategy.setColumnMapping(columns);

        return new StatefulBeanToCsvBuilder<Transaction>(writer.append(join(",", columns)).append("\n"))
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withMappingStrategy(mapStrategy)
                .withSeparator(',')
                .build();
    }

    public static void writeSummaryList(PrintWriter writer, List<Summary> summaryList, boolean ignoreMonthCol) {
        try {
            StatefulBeanToCsv<Summary> builder = getSummaryStatefulBean(writer, ignoreMonthCol);
            builder.write(summaryList);
        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    private static StatefulBeanToCsv<Summary> getSummaryStatefulBean(PrintWriter writer, boolean ignoreMonthCol) {
        ColumnPositionMappingStrategy<Summary> mapStrategy = new ColumnPositionMappingStrategy<>();

        mapStrategy.setType(Summary.class);

        String[] columns = new String[]{"month", "customer", "cumulativeRewards"};
        if(ignoreMonthCol) {
            columns = new String[]{"customer", "cumulativeRewards"};
        }
        mapStrategy.setColumnMapping(columns);

        return new StatefulBeanToCsvBuilder<Summary>(writer.append(join(",", columns)).append("\n"))
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withMappingStrategy(mapStrategy)
                .withSeparator(',')
                .build();
    }
}
