'use strict';

/**
 * agency-service service
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::agency-service.agency-service');
