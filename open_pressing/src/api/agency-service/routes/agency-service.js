'use strict';

/**
 * agency-service router
 */

const { createCoreRouter } = require('@strapi/strapi').factories;

module.exports = createCoreRouter('api::agency-service.agency-service');
